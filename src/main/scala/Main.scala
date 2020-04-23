import com.commands.gophsic.{Search, Api, Parser}
import com.utils.gophsic.EngineFuncs
import net.bmjames.opts._

import scalaz.syntax.apply._

object Main {

  def main(args: Array[String]) {
    val opts = info(Parser.parseOpts <*> helper, progDesc("A command line application for searching music"))
    val parsed = execParser(args, "Gophsic", opts)
    println(parsed)
    // parsed[2] match {
    //   case Search => {
    //     parsed
    //   }
    // }
  }
}

