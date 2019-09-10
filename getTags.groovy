import groovy.json.JsonParserType
import groovy.json.JsonSlurper
@NonCPS
def getTags()
{
    def nullTrustManager = [
            checkClientTrusted: { chain, authType ->  },
            checkServerTrusted: { chain, authType ->  },
            getAcceptedIssuers: { null }
    ]

    def nullHostnameVerifier = [
            verify: { hostname, session ->
                //true
                hostname.startsWith('yuml.me')
            }
    ]

    javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL")
    sc.init(null, [nullTrustManager as  javax.net.ssl.X509TrustManager] as  javax.net.ssl.X509TrustManager[], null)
    javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory())
    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(nullHostnameVerifier as javax.net.ssl.HostnameVerifier)


    def url = new URL('https://mysecureserver')
    url.openStream()
    def jiraHost = "http://localhost:8087"
    def testRunKey = "TEST-C1"
    def username = "admin"
    def password = "admin"
    def baseURL = "${jiraHost}/rest/atm/1.0/testrun/${testRunKey}";


    url = new URL(baseURL);

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
    return tags.collect { "@$it" }.join(',');

}
return this;