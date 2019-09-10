import groovy.json.JsonParserType
import groovy.json.JsonSlurper

def getTags()
{
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
    tags.collect { "@$it" }.join(',')

}
return tags.toString();