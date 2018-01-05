#!/usr/bin/env groovy

// open an OPML file and print out a readable text rendering of it

def opml = new XmlSlurper().parse("BeyondPodFeeds.opml")
println opml.body.outline.findAll {
    it.outline.size()
}.each { cat ->
    println cat.@text
    cat.outline.each { feed ->
        println "  ${feed.@text} - ${feed.@xmlUrl}"
    }
}
