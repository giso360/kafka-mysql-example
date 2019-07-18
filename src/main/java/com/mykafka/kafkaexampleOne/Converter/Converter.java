package com.mykafka.kafkaexampleOne.Converter;

import com.mykafka.kafkaexampleOne.exception.KafkaExampleException;

public interface Converter<I, O> {

	O convert(I input) throws KafkaExampleException;
}
