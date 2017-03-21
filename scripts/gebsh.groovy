/**
 * This is an extension script to boot up Geb and a browser
 * to facilitate interactively exploring a page with Geb.
 * % groovysh gebsh.groovy
 * groovy:000> go 'http://google.com'
 * groovy:000> println q
 * groovy:000> println $('a')*.@href
 * groovy:000> $('a')[0].click()
 * groovy:000> refresh() // to update current state from browser
 * groovy:000> println title
 * groovy:000> println currentUrl
 * groovy:000> println page.title
 * groovy:000> driver.navigate().back()
 */
import groovy.grape.Grape

Grape.grab(group: 'org.gebish', module: 'geb-core', version: '1.1.1')
Grape.grab(
    group: 'org.seleniumhq.selenium',
    module: 'selenium-firefox-driver',
    version:'3.3.1'
)

import geb.*
import org.openqa.selenium.*

browser = new Browser()

refresh = {
    driver = browser.driver
    page = browser.page
    title = browser.title
    currentUrl = browser.currentUrl
}

this.'$' = browser.&$
go = { Object[] args -> def ret = browser.go(*args); refresh(); ret }

refresh()
