package com.rp.pilot.utils;

import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.ObjectUtils;

import com.google.common.hash.Hashing;
import com.rp.pilot.model.Address;

public class HashUtils {

	public static String sha256hex(String originalText) {
		return Hashing.sha256()
				.hashString(originalText, StandardCharsets.UTF_8)
				.toString();
	}

	public static String sha256hex(Address address) {
		String zipCode = ObjectUtils.defaultIfNull(address.getZipCode(), "");
		String baseAddress = ObjectUtils.defaultIfNull(address.getBaseAddress(), "");
		String detailAddress = ObjectUtils.defaultIfNull(address.getDetailAddress(), "");
		String telNo = ObjectUtils.defaultIfNull(address.getTelNo(), "");

		StringBuilder builder = new StringBuilder()
				.append(zipCode)
				.append(baseAddress)
				.append(detailAddress)
				.append(telNo);

		return sha256hex(builder.toString().replaceAll("\\s+", ""));
	}
}
