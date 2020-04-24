package com.commands.scalic

import com.twitter.inject.annotations.Flag
import com.twitter.inject.annotations.Flags
import javax.inject.Inject
import com.twitter.inject.Injector
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
    override def configureHttp(router: HttpRouter) {
        router
        .add[ApiController]
    }
}


class ApiController extends Controller {
  get("/") { request: Request =>
    response.
        ok.
        html("""
    <!DOCTYPE HTML>
        <html>

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>Viewing Docs at Scalic Docs</title>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta name="description" content="Live Scalic server" />
            <meta name="author" content="Bisoncorps" />
            <style type="text/css">
                body,
                html {
                    margin: 0;
                    padding: 0;
                    height: 100%;
                    overflow: hidden;
                }
                
                #content {
                    position: absolute;
                    left: 0;
                    right: 0;
                    bottom: 0;
                    top: 0px;
                }
            </style>
        </head>

        <body>
            <div id="content">
                <iframe width="100%" height="100%" frameborder="0" src="https://stoplight.io/p/docs/gh/Go-phie/scalic" />
            </div>
        </body>

        </html>
    """)
  }

  get("/search") { request: Request =>
    var engineName = request.params.getOrElse("engine", false)
    var query = request.params.getOrElse("query", false)
    var uri = Url.parse(query.toString)
    val engine = EngineFuncs.getEngineByName(engineName.toString)
    engine.search(uri.toStringRaw)
  }
}