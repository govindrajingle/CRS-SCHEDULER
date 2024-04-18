<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <title>FAQ</title>
  <body>
    <section class="reg_note reg_notegal faq-page" id="skiptomaincontent">
      <div class="container">
        <div class="page-title text-center">
          <h1 class="fw-bold position-relative">frequently <span>asked</span> questions </h1>
        </div>

        <div class="accordion" id="accordionExample">
          <div class="accordion-item">
            <h4 class="accordion-header" id="headingOne">
              <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
               How much time aggregation data which was uploaded on to DAVA portal has to be maintained by manufacturer/ exporter?
              </button>
            </h4>
            <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
              <div class="accordion-body">
               Once after iVEDA is launched, from that month - the data needs to upload. Ex: If the iVEDA is launched on 15 June, then the data must be uploaded from 01 June onwards.
              </div>
            </div>
          </div>
          <div class="accordion-item">
            <h4 class="accordion-header" id="headingTwo">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
               How much time aggregation data which was not uploaded on to DAVA portal (due to extension of implementation dates) has to be maintained by manufacturer/ exporter?
              </button>
            </h4>
            <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
              <div class="accordion-body">
              No previous data is required to maintain.
              </div>
            </div>
          </div>
          <div class="accordion-item">
            <h4 class="accordion-header" id="headingThree">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                After launch of iVEDA, do the previous data has to be uploaded or not? 
              </button>
            </h4>
            <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
              <div class="accordion-body">
               After the iVEDA launch also, No previous data is required to upload.
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingFour">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseThree">
                What do the following data represent?
              </button>
            </h4>
            <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
              <div class="accordion-body">
                <ol type="a">
                    <li>HS_CODE <p> The HS (Harmonized Commodity Description and Coding System) Code is a 6-10 digit number that is required for all international shipments. This number is used by customs to identify the products shipped across international borders.</p>
                    </li>
                    <li>PROCUREMENT_SOURCE_GSTN <p>Exporter's source of procurement GSTN </p>
                    </li>
                    <li> PROCUREMENT_SOURCE_NAME <p> Exporter's source of procurement Name </p>
                    </li>
                    <li>PROCUREMENT_SOURCE_ADDRESS <p> Exporter's source of procurement Address</p>
                    </li>
                  </ol>
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingFive">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                Can we use 18 digit SSCC in the IVEDAExporterpackingdtl.xsd 
              </button>
            </h4>
            <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive" data-bs-parent="#accordionExample">
              <div class="accordion-body">
               SSCC 18-digit will be allowed - we are making this change and it will be available shortly.
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingSix">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
               In SEC_LIST, is it the same SSCC used earlier for SSCC. Is it used to co-relate Tertiary & SEC_LIST tags
              </button>
            </h4>
            <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="headingSix" data-bs-parent="#accordionExample">
              <div class="accordion-body">
               All secondary information in shipment and co-relate which secondary belongs to which Tertiary.
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingSeven">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
                In ParentCD tag, which parent serial number will go there?
              </button>
            </h4>
            <div id="collapseSeven" class="accordion-collapse collapse" aria-labelledby="headingSeven" data-bs-parent="#accordionExample">
              <div class="accordion-body">
               Tertiary serial number will go there.
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingEight">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
               The CODE_sno tag below ParentCD tag, it this tag for the secondary serial number?
              </button>
            </h4>
            <div id="collapseEight" class="accordion-collapse collapse" aria-labelledby="headingEight" data-bs-parent="#accordionExample">
              <div class="accordion-body">
               Yes
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingNine">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseNine" aria-expanded="false" aria-controls="collapseNine">
              In Srno tag, do we have to put serial number printed on Mono Carton?
              </button>
            </h4>
            <div id="collapseNine" class="accordion-collapse collapse" aria-labelledby="headingNine" data-bs-parent="#accordionExample">
              <div class="accordion-body">
               It is S1 like 10 strips or 10 vials in one S1 so serial number in S1. 
              </div>
            </div>
          </div>


          <div class="accordion-item">
            <h4 class="accordion-header" id="headingTwelve">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwelve" aria-expanded="false" aria-controls="collapseTwelve">
               Which tags will be iterated in the case of multiple SSCCs?
              </button>
            </h4>
            <div id="collapseTwelve" class="accordion-collapse collapse" aria-labelledby="headingTwelve" data-bs-parent="#accordionExample">
              <div class="accordion-body">
              Tertiary Tag
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingThirdteen">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThirdteen" aria-expanded="false" aria-controls="collapseThirdteen">
              What is the maximum size of an XML?
              </button>
            </h4>
            <div id="collapseThirdteen" class="accordion-collapse collapse" aria-labelledby="headingThirdteen" data-bs-parent="#accordionExample">
              <div class="accordion-body">
               10 MB
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingFourteen">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFourteen" aria-expanded="false" aria-controls="collapseFourteen">
              How we can update/Edit already added manufacturing site data?
              </button>
            </h4>
            <div id="collapseFourteen" class="accordion-collapse collapse" aria-labelledby="headingFourteen" data-bs-parent="#accordionExample">
              <div class="accordion-body">
              There is no current option to update/edit manufacturing site. Will discuss with Pharmaexcil as it is an amendment since it is not a good practice to edit such information on production without approvals.
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingFifteen">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFifteen" aria-expanded="false" aria-controls="collapseFifteen">
              Is there impact of not adding member details, exporting in-charge, Point of distribution on upload of data to portal ?
              </button>
            </h4>
            <div id="collapseFifteen" class="accordion-collapse collapse" aria-labelledby="headingFifteen" data-bs-parent="#accordionExample">
              <div class="accordion-body">
              This is for profile build up of the organization. Currently not mandatory. If we don't have these details, not give a good impression. However this information Is desired by MoC/regulatory body.
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingSixteen">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSixteen" aria-expanded="false" aria-controls="collapseSixteen">
              Can we provide the GTIN information as product code and IVEDA can map it with their generated IVEDA product code for portal information purpose?
              </button>
            </h4>
            <div id="collapseSixteen" class="accordion-collapse collapse" aria-labelledby="headingSixteen" data-bs-parent="#accordionExample">
              <div class="accordion-body">
              IVEDA product code will be generated and that can be mapped with GTIN.
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingSeventeen">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeventeen" aria-expanded="false" aria-controls="collapseSeventeen">
             What if we need to upload the data of only primary packs in case of having Aggregation non-Mandatory, Can the current Schema support this ?
              </button>
            </h4>
            <div id="collapseSeventeen" class="accordion-collapse collapse" aria-labelledby="headingSeventeen" data-bs-parent="#accordionExample">
              <div class="accordion-body">
              Yes you may have S1's directly under T's. There is also provision to provide primary pack information however that is optional.
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingEighteen">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEighteen" aria-expanded="false" aria-controls="collapseEighteen">
              What if we need to upload the data of only Tertiary and Primary Packs without secondary, Can the current Schema support this ? 
              </button>
            </h4>
            <div id="collapseEighteen" class="accordion-collapse collapse" aria-labelledby="headingEighteen" data-bs-parent="#accordionExample">
              <div class="accordion-body">
              Yes you may have S1's directly under T's. There is also provision to provide primary pack information however that is optional.
              </div>
            </div>
          </div>

           <div class="accordion-item">
            <h4 class="accordion-header" id="headingNinteen">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseNinteen" aria-expanded="false" aria-controls="collapseNinteen">
             SrNo is for primary serial numbers. However, as per DGFT guidelines primary serialization is optional. So under Product tag in image below, only ProdCode, BATCH_NUMBER, and Subcount tags will be included as primary package serialization is optional ?
              </button>
            </h4>
            <div id="collapseNinteen" class="accordion-collapse collapse" aria-labelledby="headingNinteen" data-bs-parent="#accordionExample">
              <div class="accordion-body">
              Yes
              </div>
            </div>
          </div>

          <div class="accordion-item">
            <h4 class="accordion-header" id="headingTwenty">
              <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwenty" aria-expanded="false" aria-controls="collapseTwenty">
             Our query is with regards to SSCC mentioned inside the secondary tag. Please understand that if there is no aggregation, users cannot know the Tertiary SSCC to which the secondary (S1) packs belong. Hence, we request you to reconfirm if SSCC (inside secondary tag) and parent CD will be optional.
              </button>
            </h4>
            <div id="collapseTwenty" class="accordion-collapse collapse" aria-labelledby="headingTwenty" data-bs-parent="#accordionExample">
              <div class="accordion-body">
             SSCC and Parent CD are both optional.
              </div>
            </div>
          </div>

        </div>

      </div>
    </section>
  </body>
</html>