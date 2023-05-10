/**
 * 
 */
package com.sharad.learn.restwebservices.currencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharad.learn.restwebservices.currencyexchangeservice.bean.ExchangeValue;

/**
 * @author koxkakku
 *
 */
public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);

}
