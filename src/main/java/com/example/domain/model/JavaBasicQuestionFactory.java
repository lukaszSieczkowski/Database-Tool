package com.example.domain.model;

public class JavaBasicQuestionFactory extends RecordFactory {

	@Override
	Record create() {
		return new JavaBasicQuestion();
	}

}
