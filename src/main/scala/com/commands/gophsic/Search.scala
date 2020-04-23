package com.commands.gophsic
import com.types.gophsic.{Engine}

case class Search(query: String) extends Command {
    def run(engine: Engine) {
        engine.search(query)
    }
}