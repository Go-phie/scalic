package com.engines.scalic

import io.lemonlabs.uri.Url
import net.ruippeixotog.scalascraper.model.Element
import com.types.scalic.{ Engine, Music }

class RedThreeMPThreeEngine extends Engine (
    Name="Red3Mp3",
    BaseURL=Url.parse("https://red3mp3.me/"),
    SearchURL=Url.parse("https://red3mp3.me/Search")
){

    override def getAttributes(): List[String] = {
        List("div.content", "div.player")
    }

    override def parseSingleMovie(elem: Element): Music = {
        new Music(Index=1,Artiste="",DownloadLink=SearchURL,Source=Name)
    }

}