/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package samples.oauth2.oltu.client.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.userdetails.OAuth2UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joe Grandja
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model, @AuthenticationPrincipal OAuth2UserDetails user) {
		populateUserInfo(model, user);
		return "user-info";
	}

	private void populateUserInfo(Model model, OAuth2UserDetails user) {
		model.addAttribute("userIdentifier", user.getIdentifier().toString());
		model.addAttribute("userAttributes", user.getAttributes().toString());
	}
}