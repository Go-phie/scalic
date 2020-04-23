import com.commands.scalic.{Search, Api, Parser, Options}
import com.utils.scalic.EngineFuncs
import com.utils.scalic.ScalicLog
import net.bmjames.opts._

import scalaz.syntax.apply._

object Main {

  def main(args: Array[String]) {
    val opts = info(Parser.parseOpts <*> helper, progDesc("A command line application for searching music"))
    val parsed = execParser(args, "Scalic", opts)
    parsed match {
      case Options(engineName, verbose, searchObj) => {
        val logger = new ScalicLog(verbose)
        logger.log("DEBUG", engineName)
      }
      case _ =>
    }
  }
}

