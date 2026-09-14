package com.example.genai.techniques;

import com.openai.models.chat.completions.ChatCompletion;

/** Checks responses before an example reports success or adds them to its history. */
public final class ChatResponses {
    private ChatResponses() {
    }

    /** Returns completed text, rejecting empty, truncated, filtered, or refused responses. */
    public static String text(ChatCompletion response) {
        if (response.choices().isEmpty()) {
            throw new IllegalStateException("The model returned no choices.");
        }
        var choice = response.choices().getFirst();
        if (!ChatCompletion.Choice.FinishReason.STOP.equals(choice.finishReason())) {
            throw new IllegalStateException("Incomplete chat response: " + choice.finishReason());
        }
        if (choice.message().refusal().filter(refusal -> !refusal.isBlank()).isPresent()) {
            throw new IllegalStateException("The model refused this request.");
        }
        return choice.message().content().filter(content -> !content.isBlank())
                .orElseThrow(() -> new IllegalStateException("The model returned no text."));
    }
}