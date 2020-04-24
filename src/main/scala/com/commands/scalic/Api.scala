package com.commands.scalic
import com.types.scalic.{Engine}
import com.twitter.finatra.http.Controller
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
import com.utils.scalic.EngineFuncs
import io.lemonlabs.uri.Url

case class Api(port: Int) extends Command {
    def run(engine: Engine) {
        engine + "Fake"
    }
}

object ApiServerMain extends ApiServer

class ApiServer extends HttpServer{
    // override val defaultHttpPort: String = ":" + flag("port", "9000", "Defines a port to use.")

    override def configureHttp(router: HttpRouter) {
        router
        .add[ApiController]
    }
}


class ApiController extends Controller {
  get("/search") { request: Request =>
    var engineName = request.params.getOrElse("engine", false)
    var query = request.params.getOrElse("query", false)
    var uri = Url.parse(query.toString)
    val engine = EngineFuncs.getEngineByName(engineName.toString)
    engine.search(uri.toStringRaw)
  }
}