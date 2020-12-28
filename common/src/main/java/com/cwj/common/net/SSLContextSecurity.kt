package com.cwj.common.net

import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.*
import javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier
import javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory
import kotlin.jvm.Throws

/**
 * ssl 证书配置
 */
object SSLContextSecurity {
    fun createIgnoreVerifySSL(sslVersion: String): SSLSocketFactory {
        var sc = SSLContext.getInstance(sslVersion);
        val trustAllCerts: Array<TrustManager> = arrayOf(object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(
                chain: Array<java.security.cert.X509Certificate>, authType: String
            ) {

            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(
                chain: Array<java.security.cert.X509Certificate>,
                authType: String
            ) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate?> {
                return arrayOfNulls(0)
            }
        })

        sc!!.init(null, trustAllCerts, java.security.SecureRandom())

        // Create all-trusting host name verifier
        val allHostsValid = HostnameVerifier { _, _ -> true }

        setDefaultSSLSocketFactory(sc.socketFactory);
        setDefaultHostnameVerifier(allHostsValid);
        return sc.socketFactory;
    }
}