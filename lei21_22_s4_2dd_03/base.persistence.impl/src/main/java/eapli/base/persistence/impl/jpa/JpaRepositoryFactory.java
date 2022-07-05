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
package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.catalogmanagement.repositories.CatalogRepository;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.countrymanagement.repository.CountryRepository;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.surveymanagement.repositories.AnswerRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.base.warehousemanagement.repositories.DockRepository;
import eapli.base.warehousemanagement.repositories.ShelfRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CustomerRepository customers(TransactionalContext autoTx) {
        return new JpaCustomerRepository(autoTx);
    }

    @Override
    public CustomerRepository customers() {
        return new JpaCustomerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CountryRepository countries(TransactionalContext autoTx) {
        return new JpaCountryRepository(autoTx);
    }

    @Override
    public CountryRepository countries() {
        return new JpaCountryRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CategoryRepository categories(final TransactionalContext transactionalContext) {
        return new JpaCategoryRepository(transactionalContext);
    }

    @Override
    public CategoryRepository categories() {
        return new JpaCategoryRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ProductRepository products(final TransactionalContext transactionalContext) {
        return new JpaProductRepository(transactionalContext);
    }

    @Override
    public ProductRepository products() {
        return new JpaProductRepository(Application.settings().getPersistenceUnitName());
    }

    /**
     * @param transactionalContext the transactional context to enroll
     */
    @Override
    public CatalogRepository catalogs(TransactionalContext transactionalContext) {
        return new JpaCatalogRepository(transactionalContext);
    }

    /**
     * repository will be created in auto transaction mode
     */
    @Override
    public CatalogRepository catalogs() {
        return new JpaCatalogRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public AGVRepository agvs(TransactionalContext autoTx) {
        return new JpaAGVRepository(autoTx);
    }

    @Override
    public AGVRepository agvs() {
        return new JpaAGVRepository(Application.settings().getPersistenceUnitName());
    }


    @Override
    public OrderRepository orders(final TransactionalContext transactionalContext) {
        return new JpaOrderRepository(transactionalContext);
    }

    @Override
    public OrderRepository orders() {
        return new JpaOrderRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public DockRepository docks(TransactionalContext transactionalContext) {
        return new JpaDockRepository(transactionalContext);
    }

    @Override
    public DockRepository docks() {
        return new JpaDockRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SurveyRepository surveys(TransactionalContext transactionalContext) {
        return new JpaSurveyRepository(transactionalContext);
    }

    @Override
    public SurveyRepository surveys() {
        return new JpaSurveyRepository(Application.settings().getPersistenceUnitName());

    }

    @Override
    public AnswerRepository answers(TransactionalContext transactionalContext) {
        return new JpaAnswerRepository(transactionalContext);
    }

    @Override
    public AnswerRepository answers() {
        return new JpaAnswerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ShelfRepository shelves() {
        return new JpaShelfRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ShelfRepository shelves(TransactionalContext transactionalContext) {
        return new JpaShelfRepository(transactionalContext);
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }
}
