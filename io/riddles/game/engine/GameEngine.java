package io.riddles.game.engine;

import java.io.IOException;
import java.util.HashMap;

import io.riddles.game.exception.InvalidInputException;
import io.riddles.game.io.Identifier;
import io.riddles.game.io.StringIdentifier;

/**
 * This interface describes the functions required for consumption of
 * GameEngine implementations.
 *
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko van Meurs <niko@riddles.io>
 */
public interface GameEngine {

    /**
     * Runs the game
     * @param initialStateString - String representation of the initial State
     */
    void run(HashMap configuration, String initialStateString) throws InvalidInputException ;
    void run(HashMap configuration) throws InvalidInputException ;
    void addPlayer(String command, Identifier id) throws IOException;

    /**
     * TODO: extend this interface to contain all functions necessary
     *       to have the match data consumed by the Riddles.io and
     *       TheAIGames libraries.
     */
}