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

	@GetMapping("/map/zone")
	fun getRoutingZones(@RequestParam("countryCodes") countryCodes: String): String {
		
		
		val url = "https://route.ls.hereapi.com/routing/7.2/getroutingzones.json?countryCodes="+countryCodes
		val token ="eyJhbGciOiJSUzUxMiIsImN0eSI6IkpXVCIsImlzcyI6IkhFUkUiLCJhaWQiOiJOY3V3dFJTdEN3Z3lJVDMzZkdRRyIsImlhdCI6MTU5Mzg3NzkyMywiZXhwIjoxNTkzOTY0MzIzLCJraWQiOiJqMSJ9.ZXlKaGJHY2lPaUprYVhJaUxDSmxibU1pT2lKQk1qVTJRMEpETFVoVE5URXlJbjAuLlYzSGNkeWJKM2Zwd2hWOE9LWlhPU0EuV0JJZ3EzNm5UTU5HeGI2c3VIOEtWb0plem1GUFk2Q21NaElKbkpzd0FFR3c3RHlDX2hYeENtZlRKcUNMLVl2LVo2X1h5TGRsVDAzczZWS2t2eHF4dzNqRlBGZlo2NHNrNTVudmpLUVFzSC1JWHBZZ1VhbURqUGx1SXJiRFliYzgudE5NT2EzM3h5Y0NMX1dCVXYwR0tHMXNNUzg4STNaazMzZ1ZLUWlveVBOVQ.ZM8vVpnpKXrLGt5MGIDQa0dSfFXkmxWxf6xNjLSHvMZycY1pNBBt6MDLyPkYbajJwfbtQUo2FlaDPT8rr5ZdWHUNHMsHFaKaQPddF88Zu2rR7p2veUUM3-XJq5y3mL1a5ILahXmQMYvzxMY79qtR0ne-47Jdsbg4XYb_AElHNzsZpC-Bi-clMXlpVNhzRnRwSixv6GW_ZHvrmWk9KkKMxzLdrL_KlAfdAbiYV9d_-4VQkJS50pFqQ0Eq8B0mhpICfIuqPy4OyKKipusMRMhD4DBHQ_N85i6N2E3ik6nHX1deKt6aDPAGwW69x04Q61jF0pALmw2-gQ88ut3YWenZmg"
		
		val client = OkHttpClient()
		val request = Request.Builder()
        .addHeader("Authorization", "Bearer "+token)
        .url(url)
        .build()

        val  response = client.newCall (request).execute()

        val body = response.body!!.string()
		
		return body;
	}
	
	
	@GetMapping("/map/evcharger")
	fun getEvCharging(@RequestParam("prox") prox: String): String {
		
		
		val url = "https://ev-v2.cit.cc.api.here.com/ev/stations.json?prox="+prox
		val token ="eyJhbGciOiJSUzUxMiIsImN0eSI6IkpXVCIsImlzcyI6IkhFUkUiLCJhaWQiOiJOY3V3dFJTdEN3Z3lJVDMzZkdRRyIsImlhdCI6MTU5Mzg3NzkyMywiZXhwIjoxNTkzOTY0MzIzLCJraWQiOiJqMSJ9.ZXlKaGJHY2lPaUprYVhJaUxDSmxibU1pT2lKQk1qVTJRMEpETFVoVE5URXlJbjAuLlYzSGNkeWJKM2Zwd2hWOE9LWlhPU0EuV0JJZ3EzNm5UTU5HeGI2c3VIOEtWb0plem1GUFk2Q21NaElKbkpzd0FFR3c3RHlDX2hYeENtZlRKcUNMLVl2LVo2X1h5TGRsVDAzczZWS2t2eHF4dzNqRlBGZlo2NHNrNTVudmpLUVFzSC1JWHBZZ1VhbURqUGx1SXJiRFliYzgudE5NT2EzM3h5Y0NMX1dCVXYwR0tHMXNNUzg4STNaazMzZ1ZLUWlveVBOVQ.ZM8vVpnpKXrLGt5MGIDQa0dSfFXkmxWxf6xNjLSHvMZycY1pNBBt6MDLyPkYbajJwfbtQUo2FlaDPT8rr5ZdWHUNHMsHFaKaQPddF88Zu2rR7p2veUUM3-XJq5y3mL1a5ILahXmQMYvzxMY79qtR0ne-47Jdsbg4XYb_AElHNzsZpC-Bi-clMXlpVNhzRnRwSixv6GW_ZHvrmWk9KkKMxzLdrL_KlAfdAbiYV9d_-4VQkJS50pFqQ0Eq8B0mhpICfIuqPy4OyKKipusMRMhD4DBHQ_N85i6N2E3ik6nHX1deKt6aDPAGwW69x04Q61jF0pALmw2-gQ88ut3YWenZmg"
		
		val client = OkHttpClient()
		val request = Request.Builder()
        .addHeader("Authorization", "Bearer "+token)
        .url(url)
        .build()

        val  response = client.newCall (request).execute()

        val body = response.body!!.string()
		
		return body;
	}

	
}