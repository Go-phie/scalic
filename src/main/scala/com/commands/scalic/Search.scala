package com.commands.scalic
import com.types.scalic.{Engine}
import com.utils.scalic.ScalicLog

case class Search(query: String) extends Command {
    override def run(engine: Engine) {
        var results = engine.search(query)
        for (music <- results) {
            println(s"Artiste: ${music.Artiste}")
            println(s"Title: ${music.Title}")
            println(s"Collection: ${music.Collection}")
            println(s"Download link: ${music.DownloadLink}")
            println("\n\n")
        }
    }
}