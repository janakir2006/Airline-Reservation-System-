package com.amritha.ars.entity;

import com.amritha.ars.dto.MealPreferences;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MealPreferencesConverter implements AttributeConverter<MealPreferences, String> {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(MealPreferences preferences) {
		try {
			return objectMapper.writeValueAsString(preferences);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("Error converting to JSON", e);
		}
	}

	@Override
	public MealPreferences convertToEntityAttribute(String dbData) {
		try {
			return objectMapper.readValue(dbData, MealPreferences.class);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error reading JSON", e);
		}
	}
}
