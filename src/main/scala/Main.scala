import com.commands.scalic.{Search, Parser, Options, ApiServer}
import com.utils.scalic.EngineFuncs
import com.utils.scalic.ScalicLog
import net.bmjames.opts._

import scalaz.syntax.apply._

object Main{

  def main(args: Array[String]) {
    val opts = info(Parser.parseOpts <*> helper, progDesc("A command line application for searching music"))
    val parsed = execParser(args, "Scalic", opts)
    parsed match {
      case Options(engineName, verbose, handler) => {
        ScalicLog.verbose = verbose
        ScalicLog.log("DEBUG", engineName)
        val engine = EngineFuncs.getEngineByName(engineName)
        handler match {
          case Search(_) => handler.run(engine)
          case _ =>
        }
      }
      case _ =>
    }
  }
}

