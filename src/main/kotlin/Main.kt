package org.example

import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


fun main() {
    val botSession = DefaultBotSession()
    val bot = Bot()
    TelegramBotsApi(botSession::class.java).registerBot(bot)
}