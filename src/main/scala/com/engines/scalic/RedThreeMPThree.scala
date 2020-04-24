package com.engines.scalic

import scala.util.matching.Regex
import io.lemonlabs.uri.Url
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model._
import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.model.Document
import com.types.scalic.{ Engine, Music }

class RedThreeMPThreeEngine extends Engine (
    Name="Red3Mp3",
    BaseURL=Url.parse("https://red3mp3.me"),
    SearchURL=Url.parse("https://red3mp3.me/Search")
){

    override def getAttributes(): List[String] = {
        List(".content", ".player")
    }

    override def parseSingleMovie(ind: Int, elem: Element): Music = {
        val downloadLink = Url.parse(BaseURL.toString +( elem >> attr("data-mp3url")))
        var remove = elem >> text("a.track-title")
        val collection = (elem >> text("div.track-info")).stripPrefix(remove)
        val ArtistandTitle = elem >> attr("data-title")
        val extractionRe = new Regex("""^(.*) — (.*)$""", "Artist", "Title")
        val ret = (extractionRe findAllMatchIn ArtistandTitle).toList
        var artist = (for (m <- extractionRe findAllMatchIn ArtistandTitle) yield m group "Artist").toList
        var title = (for (m <- extractionRe findAllMatchIn ArtistandTitle) yield m group "Title").toList
        new Music(
            Index=ind,
            Artiste=artist(0), 
            Title=title(0),
            Collection=collection,
            DownloadLink=downloadLink.toString,
            Source=Name)
    }

    override def search(query: String): List[Music] = {
        val subMap = Map ("str" -> query)
        val doc = browser.post(SearchURL.toString, subMap)
        val elist = doc >> elementList(getAttributes()(1))
        val musiclist = for { 
            (elem, ind) <- elist.zipWithIndex
        } yield parseSingleMovie(ind, elem)
        musiclist
    }

}