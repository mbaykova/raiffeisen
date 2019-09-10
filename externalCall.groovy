// If there's a call method, you can just load the file, say, as "foo", and then invoke that call method with foo(...) 
import groovy.json.JsonSlurperClassic
def call(String whoAreYou) {

    def jiraHost = "https://jira.vtb-leasing.com"
    def testRunKey = "CRM1-C288"
    def username = "mikhail.yampolskiy"
    def password = "Aplana2001!"
    def baseURL = "${jiraHost}/rest/atm/1.0/testrun/${testRunKey}";
    def authString = "${username}:${password}".bytes.encodeBase64().toString();

    def url = new URL(baseURL);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.doOutput = true
    connection.addRequestProperty("Authorization", "Basic ${authString}")
    connection.getResponseCode()
    def response = connection.getInputStream().getText()
    def jsonSlurper= new groovy.json.JsonSlurper(type: JsonParserType.INDEX_OVERLAY)
    def object = jsonSlurper.parseText(response);
    assert object instanceof Map
    String[] tags = object.items.testCaseKey
    tags.collect{"@$it"}.join(',')
}

return tags.collect{"@$it"}.join(',');
