<p align="center"><img src="assets/logo.gif" alt="scalic" height="100px"></p>

<div align="center">
  <a href="https://travis-ci.com/Go-phie/scalic">
    <img src="https://travis-ci.com/Go-phie/scalic.svg?branch=master" alt="Build Status">
  </a>
</div>

# Scalic

Search, stream and download music easily from multiple engines

## What is Scalic

Scalic is meant to be for music what <a href="https://github.com/go-phie/gophie">Gophie</a> is for movies

### Engines

- Red3Mp3


## Installation
With Scala and Sbt installed

```bash
git clone https://github.com/Go-phie/scalic.git

# assuming sbt is installed
sbt stage

#run the pakage
./target/universal/stage/bin/scalic search "Justin Timberlake Mirrors"

```
Or download from Github [Releases](https://github.com/go-phie/scalic/releases)

## Usage

```
Usage: Scalic [--engine ARG] [--verbose] COMMAND
  A command line application for searching music

Available options:
  -h,--help                Show this help text
  --engine ARG             engine, defaults to red3mp3
  --verbose                verbose mode flag
  COMMAND                  

Available commands:
  search                   
  api  
```

Example is running 

```bash
  Scalic search "born to die"

Artiste: Leftöver Crack
Title: Born To Die
Collection:  Mediocre Generica, 2008
Download link: https://red3mp3.me/stream/2950318/leftover-crack-born-to-die.mp3



Artiste: Party Hit Kings
Title: Born to Die
Collection:  Club Remix Club Remix Hits 2012, Vol. 1, 2012
Download link: https://red3mp3.me/stream/5435692/party-hit-kings-born-to-die.mp3



Artiste: Tiamat
Title: Born to Die
Collection:  Bonus Track The Scarred People, 2012
Download link: https://red3mp3.me/stream/7218747/tiamat-born-to-die.mp3



Artiste: Aston, Aston
Title: Born to Die
Collection:  Born to Die, 2012
Download link: https://red3mp3.me/stream/10248314/aston-born-to-die.mp3



Artiste: Gangstagrass
Title: Born to Die
Collection:  Instrumental American Music, 2016
Download link: https://red3mp3.me/stream/29952362/gangstagrass-born-to-die.mp3



Artiste: Sarah Where Is My Tea
Title: Born to Die
Collection:  Bonus Track Love & Honor, 2013
Download link: https://red3mp3.me/stream/35346490/sarah-where-is-my-tea-born-to-die.mp3



Artiste: Slaughter to Prevail
Title: Born to Die
Collection:  Misery Sermon, 2017
Download link: https://red3mp3.me/stream/36213545/slaughter-to-prevail-born-to-die.mp3



Artiste: Skyweep
Title: Born To Die 4 Drums
Collection:  Original Mix Edits 1 EP, 2013
Download link: https://red3mp3.me/stream/45068776/skyweep-born-to-die-4-drums.mp3



Artiste: Bathory
Title: Born to Die
Collection:  Remastered In Memory of Quorthon Vol I, 2006
Download link: https://red3mp3.me/stream/46188383/bathory-born-to-die.mp3



Artiste: Syd Arthur
Title: Born to Live Born to Die (Dorothy)
Collection:  Amorphous Androgynous Remix A Monstrous Psychedelic Bubble, 2014
Download link: https://red3mp3.me/stream/48812389/syd-arthur-born-to-live-born-to-die-dorothy.mp3



Artiste: Anonyme
Title: Born To Die
Collection:  Collaborations 3, 2019
Download link: https://red3mp3.me/stream/53867513/anonyme-born-to-die.mp3



Artiste: Kelly Clarkson
Title: Born to Die
Collection:  TROLLS World Tour, 2020
Download link: https://red3mp3.me/stream/64791054/trolls-world-tour-born-to-die.mp3



Artiste: besomorph, Coopex, EthanUno
Title: Born To Die
Collection:  Born To Die, 2020
Download link: https://red3mp3.me/stream/64955072/born-to-die-born-to-die.mp3
```

## Deployment

The deployed API version from `scalic api` is available on [Heroku](https://scalic.herokuapp.com). Please read the API documentation for usage

## License

This project is opened under the [GNU AGPLv3](https://github.com/go-phie/scalic/blob/master/LICENSE) which allows very broad use for both academic and commercial purposes.


## Credits
Library/Resource | Use
------- | -----
[https://github.com/ruippeixotog/scala-scraper](https://github.com/ruippeixotog/scala-scraper) | scraping the net for links
[https://github.com/bmjames/scala-optparse-applicative](https://github.com/bmjames/scala-optparse-applicative) | CLI interface
[Stoplight](https://stoplight.io) | Generating API docs
