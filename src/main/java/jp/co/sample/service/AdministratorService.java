package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * 管理者情報を登録する業務処理を行うメソッドを作成します。
 * 
 * @author kashimamiyu
 *
 */
@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;

	/**
	 * 管理者情報を挿入する。
	 * 
	 * @param administrator
	 */
	public void insert(Administrator administrator) {

		administratorRepository.insert(administrator);

	}

	/**
	 * ログイン処理をする。
	 * 
	 * @param mailAddress
	 * @param password
	 * @return 管理者情報
	 */
	public Administrator login(String mailAddress, String passward) {
		Administrator administrator = administratorRepository.findByMailAddressAndPassword(mailAddress, passward);
		return administrator;
	}

}
