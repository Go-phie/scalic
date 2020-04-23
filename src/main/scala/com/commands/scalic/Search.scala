package com.commands.scalic
import com.types.scalic.{Engine}

case class Search(query: String) extends Command {
    def run(engine: Engine) {
        engine.search(query)
    }
}