import io.gatling.core.Predef._
import io.gatling.core.config.GatlingConfiguration.configuration
import io.gatling.http.Predef._

import scala.concurrent.duration._

class PerformanceSimulation extends Simulation {

  val httpConf = http.baseURL("http://localhost:5000")

  val users = 10
  val rampTimeInMinutes = 1
  val steadyStateDuration = 5
  val duration = (steadyStateDuration + rampTimeInMinutes) minutes

  val scn = scenario("Get Index")
    .during(duration) {
    pace(5 second, 10 seconds)
      exec(http("Get Index")
        .get("/")
        .check(status.is(200)))
  }

  setUp(
    scn.inject(rampUsers(users) over (rampTimeInMinutes minutes)))
    .protocols(httpConf)
}
