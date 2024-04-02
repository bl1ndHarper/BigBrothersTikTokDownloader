# Big Brother's TikTok Downloader


Big Brother's TikTok Downloader is a simple Telegram bot which uses ['Tiktok full info without watermark' API by maatootz](https://rapidapi.com/maatootz/api/tiktok-full-info-without-watermark) from Rapid API and Telegram API to download videos from TikTok. The bot takes a TikTok video url link from user and sends back the video file without watermark. It can be used by a single user or connected to a group chat. All that user needs to use such bot is to ```/start``` it and then send a TikTok video link.

`Please, take into account that this is not a serious ready-to-go project and better consider it as a mere joke than an example to follow`


## Features
**There are some features that can be annoying and no one really needs in this bot.**
##### Here are the main ones:
- Simple in its usage by end users;
- Can answear with a 1984 quote with a 0,5% chance if user sends something other than a command or a tiktok link (more relevant for group chats);
- Fully written in Kotlin (I consider it an advantage);
- It just works...

## Future development
Now this program allows a Telegram bot to only download videos but it should also be able to download photos and music from a TikTok post.

## Getting Started

**If you are just looking for a way to download a TikTok video without watermark, [here is my bot](https://t.me/bbs_tt_stealer_bot) which works on this exact program code. Please, do not overload it, as this is a non-commercial project that has a limit on the number of requests processed.**

If you are a programmer that aims to learn creating Telegram bots with Kotlin then follow these steps to make your one:
- Create your Kotlin project: clone this repository;
- Register on RapidAPI and find "X-RapidAPI-Key" and "X-RapidAPI-Host" values in the 'Code Snippets' tab [here](https://rapidapi.com/maatootz/api/tiktok-full-info-without-watermark);
- Chat to [BotFather](https://t.me/BotFather) to create your Telegram bot and get its Username and Token;

Next you can paste the config values manually or create a config.properties file in you project as I did:
##### 1) For the first (manual) option:
- Open **Bot.kt** file and set a `getBotToken()` function return value as this

```override fun getBotToken(): String = "[Your_BotToken_from_BotFather]"```

and `getBotUsername()` as this

```override fun getBotUsername(): String = "[Your_BotUsername_from_BotFather]"```;

- Then open **TikTokLinkParser.kt**, go down to the `getMediaUrl()` function and paste yor X-RapidAPI-Key and X-RapidAPI-Host values as follows:

```
.addHeader("X-RapidAPI-Key", "[Your_X-RapidAPI-Key_Value]")
.addHeader("X-RapidAPI-Host", "[Your_X-RapidAPI-Host_Value]")
```

##### 2) For the second (secure) option:
- Create a **config.properties** file in your project root folder and paste you values there like this:
```
# API Config
X-RapidAPI-Key=[Your_X-RapidAPI-Key_Value]
X-RapidAPI-Host=[Your_X-RapidAPI-Host_Value]

# Bot Config
BotUsername=[Your_BotUsername_from_BotFather]
BotToken=[Your_BotToken_from_BotFather]
```

Next run the project and your bot must work now.
It will be up as the program is running so you should use a server to make your bot online all the time (or just run the program on your pc when you need the bot 😇)


## License

MIT
