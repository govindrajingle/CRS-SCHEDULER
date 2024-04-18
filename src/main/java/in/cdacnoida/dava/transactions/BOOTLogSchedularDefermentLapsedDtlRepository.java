package in.cdacnoida.dava.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.cdacnoida.dava.entities.BOOTLogSchedularDefermentLapsedDtl;

@Repository
public interface BOOTLogSchedularDefermentLapsedDtlRepository extends JpaRepository<BOOTLogSchedularDefermentLapsedDtl, Long>{

	@Modifying
	@Transactional
	@Query(value = "insert into log_schedular_deferment_lapsed_dtl " + 
	    "(application_id,reg_number,reg_date,valid_upto,tr_dt,seq_no " + 
	    ",str_target_status,str_old_status,mail_send_content,is_no " + 
	    ",product_category,brand_name,email_in_form_vi,email_contact_person " + 
	    ",email_indian_rep,user_email,str_user_id,str_manufacturing_unit " + 
	    ",str_manufacure_address,name_of_ind_representative,address_of_ind_rep, email_delivered,email_correspondence,is_processed ) " + 
	    "(select crm.application_id,crm.reg_number,crm.reg_date,crm.valid_up_to,sysdate " + 
	    ",(select nvl(max(seq_no),0)+1 from log_schedular_deferment_lapsed_dtl) as seq_no " + 
	    ",:newStatus,:oldStatus " + 
	    ",'' as mail_content " + 
	    ",get_standard_number(cam.standard_id) as isno " + 
	    ",get_product_category(cam.product_category) as product_category " + 
	    ",get_brand_name(cam.application_id) as brand_name " + 
	    ",nvl(cma.m_email,'NA')  as email_in_form_vi " + 
	    ",nvl(cam.applicant_emailid,'NA') as email_contact_person " + 
	    ",nvl(cam.email_id_of_ind_rep,'NA') as  email_indian_rep " + 
	    ",nvl(tur.str_e_mail,'NA') as user_email " + 
	    ",tur.str_user_id as str_user_id " + 
	    ",get_manf_unit(tur.str_user_id) as str_manufacturing_unit " + 
	    ",cma.m_address||', '||upper(get_country_name(cma.m_country)) as str_manufacturing_address " + 
	    ",cam.name_of_ind_representative as name_of_ind_representative " + 
	    ",cam.address_of_ind_rep as address_of_ind_rep,'N',nvl(cma.o_email,'NA')  as email_correspondence,'N' " + 
	    "from creit_registration_master crm, " + 
	    "creit_application_master cam, " + 
	    "tdc_user_registration tur, " + 
	    "creit_manufacturing_address cma " + 
	    "where cam.application_id=crm.application_id " + 
	    "and tur.str_user_id=cam.str_user_id " + 
	    "and cma.man_address_id=tur.man_address_id " + 
	    "and cma.company_id=tur.company_id " + 
	    "and crm.reg_number = :reg_no " + 
	    "and crm.application_id= :application_id)", nativeQuery = true)
	void insertData(@Param("newStatus") String newStatus, @Param("oldStatus") String oldStatus, @Param("reg_no") String reg_no, @Param("application_id") String application_id);

}
