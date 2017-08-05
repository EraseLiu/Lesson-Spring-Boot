package readinglist;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class ReadingListControllerTest {

	@Test
	public void shouldReturnReadingListFromRepository() throws Exception {
		List<Book> expectedList = new ArrayList<Book>();
		expectedList.add(new Book());
		ReadingListRepository mockRepo = mock(ReadingListRepository.class);
		when(mockRepo.findByReader("Craig")).thenReturn(expectedList);
		ReadingListController controller = new ReadingListController(mockRepo, null);
		MockMvc mvc = standaloneSetup(controller).build();
		mvc.perform(get("/")).andExpect(view().name("readingList")).andExpect(model().attribute("books", expectedList));
	}

}
