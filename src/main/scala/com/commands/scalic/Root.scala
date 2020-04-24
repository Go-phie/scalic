package com.commands.scalic

import net.bmjames.opts._
import scalaz.syntax.apply._
import com.twitter.finatra.http.HttpServer
import com.types.scalic.{Engine}

case class Options(engine: String, verbose: Boolean = false, command: Command)

trait Command {
  def run(engine: Engine)
}

object Parser {
      val parseOpts: Parser[Options] =
    ^^(strOption(long("engine"), help("engine, defaults to red3mp3"))  <|> pure("red3mp3"),
       switch(long("verbose"),   help("verbose mode flag")),
       subparser[Command](command("search", info(strArgument(metavar("QUERY")).map(Search))),
                        command("api", info(intArgument(metavar("PORT")).map(Api))))
    )(Options)
}
