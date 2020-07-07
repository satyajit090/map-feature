package com.demo.map.api

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import okhttp3.OkHttpClient
import okhttp3.Request

@RestController
class MapController {

	@GetMapping("/map")
	fun getMap(@RequestParam("at") at: String): String {

		val urlEatDrink = "https://places.ls.hereapi.com/places/v1/discover/explore?at=" + at + "&cat=eat-drink"

		val urlEvCharging = "https://places.ls.hereapi.com/places/v1/discover/explore?at=" + at + "&cat=ev-charging-station"
		val token =
			"eyJhbGciOiJSUzUxMiIsImN0eSI6IkpXVCIsImlzcyI6IkhFUkUiLCJhaWQiOiJOY3V3dFJTdEN3Z3lJVDMzZkdRRyIsImlhdCI6MTU5NDA5MTA1NiwiZXhwIjoxNTk0MTc3NDU2LCJraWQiOiJqMSJ9.ZXlKaGJHY2lPaUprYVhJaUxDSmxibU1pT2lKQk1qVTJRMEpETFVoVE5URXlJbjAuLlVMN2hWaWVfdlhRYldtdl84S1hoRFEuaEJ0cjJKYUdBNDZoVmNiQlFmZkFNUm9YV0NUQmlGMHNHbl83YkxrYi16MTJOTFUyNF9FRzBJbVc2UkpTS190NDhwM2lvbGR3dDIyR3hxLTUyWExnX0xDd2s3ekhYbkY3NWxpeHVJN0ZTeVlOeGNfRXk0ZW9TSkFCT20yLTFDblYuRVd6UHFHUDk3WTl5VFRzWkFudFJiV0FUSXVmU2hEQlZXTGo1b0NlMFVSdw.qQ8B3hzHqOBDrFeYROIWdF81R1VFoC3gCX9XDKXEqkkfi_-ocSiaCi2-X9dYHQqO1vhIZHc7Q2o2EqOgmgl2-KDw6gL0KUY6rTUi8Eo2MJ2MU1BftP9Z05UlGKj-2lISgxJqR6MzDv0rUsG6B6Wc6plCj6Wak5hU_kfsgRQ__JR0G3kPM0JEBcdHlQcqTJ5rhLhwgXgIyNQGTMqgp4vsw-Olv97_qOEgb-UXasYoyf6rxO0CqVB2JwVjgEhmdpwh6oP4ARKUYEbKpu8iK0Ehs2NH8_skBy95CONYgV8lbjk4zDcRb1ZmLx6fITdrJtrSdVPt_mDefpbquYeP7FGuGA"

		val clientEatDrink = OkHttpClient()
		val requestEatDrink = Request.Builder()
			.addHeader("Authorization", "Bearer " + token)
			.url(urlEatDrink)
			.build()

		val responseEatDrink = clientEatDrink.newCall(requestEatDrink).execute()

		val bodyEatDrink = responseEatDrink.body!!.string()


		val clientEvCharging = OkHttpClient()
		val requestEvCharging = Request.Builder()
			.addHeader("Authorization", "Bearer " + token)
			.url(urlEvCharging)
			.build()

		val responseEvCharging = clientEvCharging.newCall(requestEvCharging).execute()

		val bodyEvCharging = responseEvCharging.body!!.string()

		return bodyEatDrink + bodyEvCharging;
	}


}