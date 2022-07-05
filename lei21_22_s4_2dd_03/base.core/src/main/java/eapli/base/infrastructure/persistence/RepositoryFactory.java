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
package eapli.base.infrastructure.persistence;

import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.catalogmanagement.repositories.CatalogRepository;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.countrymanagement.repository.CountryRepository;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.surveymanagement.repositories.AnswerRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.base.warehousemanagement.repositories.DockRepository;
import eapli.base.warehousemanagement.repositories.ShelfRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     * @param autoTx the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();


    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    CustomerRepository customers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CustomerRepository customers();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    CountryRepository countries(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CountryRepository countries();


    CategoryRepository categories(TransactionalContext transactionalContext);

    /**
     * repository will be created in auto transaction mode
     */
    CategoryRepository categories();

    /**
     * @param transactionalContext the transactional context to enroll
     */
    ProductRepository products(TransactionalContext transactionalContext);

    /**
     * repository will be created in auto transaction mode
     */
    ProductRepository products();

    /**
     * @param transactionalContext the transactional context to enroll
     */
    CatalogRepository catalogs(TransactionalContext transactionalContext);

    /**
     * repository will be created in auto transaction mode
     */
    CatalogRepository catalogs();


    /**
     * @param autoTx the transactional context to enroll
     */
    AGVRepository agvs(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     */
    AGVRepository agvs();

    /**
     * @param transactionalContext the transactional context to enroll
     */
    OrderRepository orders(TransactionalContext transactionalContext);

    /**
     * repository will be created in auto transaction mode
     */
    OrderRepository orders();

    /**
     * @param transactionalContext the transactional context to enroll
     */
    DockRepository docks(TransactionalContext transactionalContext);

    /**
     * repository will be created in auto transaction mode
     */
    DockRepository docks();

    /**
     * @param transactionalContext the transactional context to enroll
     */
    SurveyRepository surveys(TransactionalContext transactionalContext);


    /**
     * repository will be created in auto transaction mode
     */
    SurveyRepository surveys();

    /**
     * @param transactionalContext the transactional context to enroll
     */
    AnswerRepository answers(TransactionalContext transactionalContext);

    /**
     * repository will be created in auto transaction mode
     */
    AnswerRepository answers();

    ShelfRepository shelves();

    ShelfRepository shelves(TransactionalContext transactionalContext);


}
