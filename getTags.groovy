import groovy.json.JsonParserType
import groovy.json.JsonSlurper

import javax.net.ssl.KeyManager
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLEngine
import javax.net.ssl.TrustManager
import javax.net.ssl.X509ExtendedTrustManager
import java.security.cert.X509Certificate

@NonCPS
def getTags()
{
    TrustManager trustAllCert =   new X509ExtendedTrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) {  }
        public void checkClientTrusted(X509Certificate[] certs, String authType, SSLEngine engine ) {  }
        public void checkClientTrusted(X509Certificate[] certs, String authType, Socket engine ) {  }
        public void checkServerTrusted(X509Certificate[] certs, String authType) {  }
        public void checkServerTrusted(X509Certificate[] certs, String authType, Socket engine ) {  }
        public void checkServerTrusted(X509Certificate[] certs, String authType, SSLEngine engine ) {  }
    }

    TrustManager[] trustAllCerts = new TrustManager[1];
    trustAllCerts[0] = trustAllCert;
    try {
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(new KeyManager[0], trustAllCerts, new java.security.SecureRandom());

        url.openStream()
        def jiraHost = "http://localhost:8087"
        def testRunKey = "TEST-C1"
        def username = "admin"
        def password = "admin"
        def baseURL = "${jiraHost}/rest/atm/1.0/testrun/${testRunKey}";


        url = new URL(baseURL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setSSLSocketFactory(sc.getSocketFactory())
        connection.doOutput = true
        connection.addRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4=")
        connection.getResponseCode()
        def response = connection.getInputStream().getText()
        def jsonSlurper = new groovy.json.JsonSlurper(type: JsonParserType.INDEX_OVERLAY)
        def object = jsonSlurper.parseText(response);
        assert object instanceof Map

        sc.getSocketFactory()
        String[] tags = object.items.testCaseKey
        return tags.collect { "@$it" }.join(',');
    } catch (Exception e) { }




}
return this;