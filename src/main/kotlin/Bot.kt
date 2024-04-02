package org.example

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.send.SendVideo
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class Bot: TelegramLongPollingBot() {
    override fun getBotToken(): String = Configuration.getProperty("BotToken")

    override fun getBotUsername(): String = Configuration.getProperty("BotUsername")

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            val message = SendMessage()
            val chatId = update.message.chatId.toString()
            message.chatId = chatId
            var messageText = ""

            if (update.message.text == "/start") {
                messageText = "War is peace.\n" +
                        "Freedom is slavery.\n" +
                        "Ignorance is strength.\n\n" +
                        "Remember! Big Brother is watching you!"
                message.text = messageText
                execute(message)
            } else {
                if (TikTokLinkParser.isTikTokUrl(update.message.text)) {
                    val mediaUrl = TikTokLinkParser.getMediaUrl(update.message.text)
                    try {
                        val video = SendVideo()
                        video.chatId = chatId
                        video.video = InputFile(mediaUrl)
                        execute(video)
                    } catch (e: TelegramApiException) {
                        message.text = "Big Brother didn't approve this video so it has been vaporized.\n" +
                                "From now on it's never existed!"
                        execute(message)
                        e.printStackTrace()
                    }
                }
                else if (Quoter.shouldBotRespond()) {
                    val str = Quoter.getRandomMessage()
                    message.text = str
                    execute(message)
                }
            }
        }
    }
}