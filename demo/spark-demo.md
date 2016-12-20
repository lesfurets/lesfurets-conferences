```
-- Nombre de PPS où direct assurance a été vu
-- numérateur de quotabilité
-- dénominateur de taux de clic
SELECT
	count(DISTINCT gaqa.ref_auto_offre_uid)
FROM
	olap_quotation.AUTO_VIEW_QUOTES avq
	JOIN olap_quotation.GEN_AUTO_QUOTES_ALL gaqa on (avq.id_quotes = gaqa.id)
WHERE TRUE
	AND  gaqa.creation_date='2016-12-14'
	AND avq.ref_providers=48;
	
-- Nombre de PPS vues avec au moins un partenaire
-- dénominateur quotabilité
-- pour avoir aussi les PPS sans tarifs, il vaudrait
-- mieux lire dans AUTO_QUOTATION_REQUEST (avec le biais de compter
-- les appels d'orchestrateurs non vus
SELECT
	count(DISTINCT gaqa.ref_auto_offre_uid)
FROM
	olap_quotation.AUTO_VIEW_QUOTES avq
	JOIN olap_quotation.GEN_AUTO_QUOTES_ALL gaqa on (avq.id_quotes = gaqa.id)
WHERE TRUE
	AND  gaqa.creation_date='2016-12-14';

-- nombre de clics sur une PPS sur au moins un des boutons de 
-- direct assurance
SELECT
	count(DISTINCT bl.ref_offre_uid)
FROM
	olap_quotation.BIL_LEADS bl
WHERE TRUE
	AND bl.creation_date='2016-12-14'
	AND bl.ref_customers=48;	
	
-- pour la liste des assureurs, voir :
-- attention aux doublons type Allianz
-- attention la colonne y faisant référence
-- peut s'appeler ref_providers ou ref_customers	
SELECT
	*
FROM
	olap_quotation.REF_PROVIDERS;
1 Comment
```

