import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the NetworkAssignModify entity.
 */
class NetworkAssignModifyGatlingTest extends Simulation {

    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    // Log all HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    // Log failed HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("DEBUG"))

    val baseURL = Option(System.getProperty("baseURL")) getOrElse """http://localhost:8080"""

    val httpConf = http
        .baseUrl(baseURL)
        .inferHtmlResources()
        .acceptHeader("*/*")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
        .connectionHeader("keep-alive")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0")
        .silentResources // Silence all resources like css or css so they don't clutter the results

    val headers_http = Map(
        "Accept" -> """application/json"""
    )

    val headers_http_authentication = Map(
        "Content-Type" -> """application/json""",
        "Accept" -> """application/json"""
    )

    val headers_http_authenticated = Map(
        "Accept" -> """application/json""",
        "Authorization" -> "${access_token}"
    )

    val scn = scenario("Test the NetworkAssignModify entity")
        .exec(http("First unauthenticated request")
        .get("/api/account")
        .headers(headers_http)
        .check(status.is(401))
        ).exitHereIfFailed
        .pause(10)
        .exec(http("Authentication")
        .post("/api/authenticate")
        .headers(headers_http_authentication)
        .body(StringBody("""{"username":"admin", "password":"admin"}""")).asJson
        .check(header("Authorization").saveAs("access_token"))).exitHereIfFailed
        .pause(2)
        .exec(http("Authenticated request")
        .get("/api/account")
        .headers(headers_http_authenticated)
        .check(status.is(200)))
        .pause(10)
        .repeat(2) {
            exec(http("Get all networkAssignModifies")
            .get("/services/jhipsternetworkapplication/api/network-assign-modifies")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new networkAssignModify")
            .post("/services/jhipsternetworkapplication/api/network-assign-modifies")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "id":null
                , "autoId":null
                , "title":"SAMPLE_TEXT"
                , "updateTime":"0"
                , "modifySource":"ITSM"
                , "externalId":"0"
                , "modifyType":"IPAPPLY"
                , "modifiedCount":"0"
                , "modifyStatus":"ITSM"
                , "orderDetailId":"0"
                , "managerId":"0"
                , "managerValue":"SAMPLE_TEXT"
                , "systemId":"0"
                , "systemValue":"SAMPLE_TEXT"
                , "departmentId":"0"
                , "departmentValue":"SAMPLE_TEXT"
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_networkAssignModify_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created networkAssignModify")
                .get("/services/jhipsternetworkapplication${new_networkAssignModify_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created networkAssignModify")
            .delete("/services/jhipsternetworkapplication${new_networkAssignModify_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
