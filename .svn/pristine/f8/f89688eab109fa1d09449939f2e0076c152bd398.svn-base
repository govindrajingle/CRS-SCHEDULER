package in.cdacnoida.dava.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DistributionMstDomain;
import in.cdacnoida.dava.entities.RegionMstDomain;
import in.cdacnoida.dava.model.PointsOfDisModel;

public interface PointsOfDisService {

	String ShowPointsOfDistributionDtls(HttpServletRequest request);

	List<RegionMstDomain> loadRegion();

	List<CountryMst> loadCountry();

	DistributionMstDomain addDistributionMstDetail(PointsOfDisModel pointsOfDisModel, HttpServletRequest request);

}
