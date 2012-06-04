/*
 * Copyright (C) 2012 Aonyx
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.aonyx.broker.ib.api.account;

import static ch.aonyx.broker.ib.api.util.InputStreamUtils.readString;

import java.io.InputStream;

import ch.aonyx.broker.ib.api.io.AbstractEventCreatingInputStreamConsumerSupport;

/**
 * @author Christophe Marcourt
 * @since 1.0.0
 */
public final class AccountUpdateValueEndEventCreatingInputStreamConsumer extends
		AbstractEventCreatingInputStreamConsumerSupport<AccountUpdateValueEndEvent> {

	public AccountUpdateValueEndEventCreatingInputStreamConsumer(final InputStream inputStream,
			final int serverCurrentVersion) {
		super(inputStream, serverCurrentVersion);
	}

	@Override
	protected AccountUpdateValueEndEvent consumeVersionLess(final InputStream inputStream) {
		final String accountName = readString(inputStream);
		return createEvent(accountName);
	}

	private AccountUpdateValueEndEvent createEvent(final String accountName) {
		return new AccountUpdateValueEndEvent(accountName);
	}
}
