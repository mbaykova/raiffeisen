import groovy.json.JsonParserType
import groovy.json.JsonSlurper

import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager


class TrustManager implements X509TrustManager {
    public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null;  }
    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) { }
    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) { }
}

def getTags()
{


    TrustManager[] trustAllCerts = new TrustManager[1]
    trustAllCerts[0] = new TrustManager()
    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());




    def jiraHost = "http://localhost:8087"
    def testRunKey = "TEST-C1"
    def username = "admin"
    def password = "admin"
    def baseURL = "${jiraHost}/rest/atm/1.0/testrun/${testRunKey}";


    def url = new URL(baseURL);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.doOutput = true
    connection.addRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4=")
    connection.getResponseCode()
    def response = connection.getInputStream().getText()
    def jsonSlurper = new groovy.json.JsonSlurper(type: JsonParserType.INDEX_OVERLAY)
    def object = jsonSlurper.parseText(response);
    assert object instanceof Map
    String[] tags = object.items.testCaseKey
    print tags
    return tags.collect { "@$it" }.join(',');

}
return this;