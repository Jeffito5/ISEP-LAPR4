/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.bootstrapers.UsersBootstrapperBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import eapli.base.clientusermanagement.application.AcceptRefuseSignupFactory;
import eapli.base.clientusermanagement.application.AcceptRefuseSignupRequestController;
import eapli.base.clientusermanagement.domain.SignupRequest;
import eapli.base.infrastructure.bootstrapers.TestDataConstants;
import eapli.base.myclientuser.application.SignupController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

/**
 * @author Paulo Sousa
 */
public class ClientUserBootstrapper extends UsersBootstrapperBase implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            ClientUserBootstrapper.class);

    private final SignupController signupController = new SignupController();
    private final AcceptRefuseSignupRequestController acceptController = AcceptRefuseSignupFactory
            .build();

    @Override
    public boolean execute() {

        signupAndApprove(TestDataConstants.USER_TEST1, TestDataConstants.PASSWORD1, "John", "Smith",
                "john@smith.com", TestDataConstants.USER_TEST1);

        signupAndApprove("RitaSilva", TestDataConstants.PASSWORD1, "Ana", "Rita", "anaRita@gmail.com", "1201228");
        signupAndApprove("GuilhermeSencadas", TestDataConstants.PASSWORD1, "Guilherme", "Sencadas", "guilhermeSencadas@gmail.com", "1201180");
        signupAndApprove("LucasGuimaraes", TestDataConstants.PASSWORD1, "Lucas", "Guimaraes", "lucasGuimaraes@gmail.com", "1201216");
        signupAndApprove("MarcoRamos", TestDataConstants.PASSWORD1, "Marco", "Ramos", "marcoRamos@gmail.com", "1201217");
        signupAndApprove("LuisAraujo", TestDataConstants.PASSWORD1, "Luis", "Araujo", "luisAraujo@gmail.com", "1190827");
        return true;
    }

    /**
     * Registers a user in the App
     *
     * @param username            User's chosen username
     * @param password            User's Password
     * @param firstName           User's First Name
     * @param lastName            User's Last Name
     * @param email               User's email
     * @param mecanographicNumber User's Mecanographic Number
     * @return SignupRequest
     */
    public SignupRequest signupAndApprove(final String username, final String password,
                                          final String firstName, final String lastName, final String email,
                                          final String mecanographicNumber) {
        SignupRequest request = null;
        try {
            request = signupController.signup(username, password, firstName, lastName, email,
                    mecanographicNumber);
            acceptController.acceptSignupRequest(request);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", username);
            LOGGER.trace("Assuming existing record", e);
        }
        return request;
    }
}
