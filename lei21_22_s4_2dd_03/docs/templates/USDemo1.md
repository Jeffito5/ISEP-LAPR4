# USDemo1
=======================================

# 1. Requirements

*In this section the team should indicate the developed functionality as well as describe its interpretation and its
correlation and/or dependency of/with others requirements.*

*Example*

**Demo1** As {Actor} I want to...

- Demo1.1. Blá Blá Blá ...

- Demo1.2. Blá Blá Blá ...

The interpretation of this requirement was...

# 2. Analysis

*In this section the team should describe the study/analysis/comparison done with the meaning to take the best options
of design for the functionality as well as apply the suited diagrams/artifacts of analysis.*

*It is recommended to organize the content by subsections.*

# 3. Design

*In this section the team should describe the adopted design to satisfy the functionality. Among others, the team should
present the functionality development diagram(s), class diagram(s), identification of patterns applied and which were the
principal tests specified to validate the functionality.*

*Beyond the suggested sections, others can be included.*

## 3.1. Functionality development

*In this section should be presented and described the flow/sequence that allows to run the functionality.*

## 3.2. Class Diagram

*In this section should be presented and described the main classes involved in the functionality development.*

## 3.3. Applied patterns

*In this section show be presented and explained which were the design patterns applied and the best practices.*

## 3.4. Tests
*In this section should be systemized how the tests were developed to allow a correct way to scout the requirement satisfaction.*

**Test 1:** Bla Bla Bla

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

# 4. Implementation

*In this section the team show provide, if necessary, some evidence that the implementation is in accordance with the design developed.
Beyond that, show be mentioned/described the existence of any other relevant file (e.g. configuration) e highlight relevant commits.*

*It is recommended to organize this content in subsections.*

# 5. Integration/Demonstration

*In this section the team should describe the efforts made to integrate the developed functionality with the remaining functionality of the system.*

# 6. Observations

*In this section is suggested to present a critic view about the pointed developed work, for example, other ways and/or future works related.*