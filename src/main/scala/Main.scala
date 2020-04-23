import com.commands.scalic.{Search, Api, Parser}
import com.utils.scalic.EngineFuncs
import net.bmjames.opts._

import scalaz.syntax.apply._

object Main {

  def main(args: Array[String]) {
    val opts = info(Parser.parseOpts <*> helper, progDesc("A command line application for searching music"))
    val parsed = execParser(args, "Scalic", opts)
    println(parsed)
    // parsed[2] match {
    //   case Search => {
    //     parsed
    //   }
    // }
  }
}

