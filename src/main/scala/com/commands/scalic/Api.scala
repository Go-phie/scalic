package com.commands.scalic
import com.types.scalic.{Engine}
import com.twitter.finatra.http.Controller
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

case class Api(port: Int) extends HttpServer with Command {
    def run(engine: Engine) = {
        build()
    }

    override val defaultHttpPort: String = s":${port.toString}"
    override def configureHttp(router: HttpRouter) {
        router
        .add[ApiController]
    }
}


class ApiController extends Controller {
  get("/search") { request: Request =>
    // println(request)
    var engine = request.params.getOrElse("engine", false)
    var query = request.params.getOrElse("query", false)
  }
}