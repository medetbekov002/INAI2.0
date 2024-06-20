package com.example.myapplication.ui.search;import android.content.Context;import android.os.Bundle;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.view.inputmethod.InputMethodManager;import androidx.annotation.NonNull;import androidx.annotation.Nullable;import androidx.appcompat.widget.SearchView;import androidx.fragment.app.Fragment;import androidx.navigation.fragment.NavHostFragment;import androidx.recyclerview.widget.LinearLayoutManager;import com.example.myapplication.R;import com.example.myapplication.databinding.FragmentSearchBinding;import com.example.myapplication.ui.search.adapter.SearchResultAdapter;import com.example.myapplication.ui.search.model.SearchResult;import java.util.ArrayList;import java.util.List;public class SearchFragment extends Fragment {    private FragmentSearchBinding binding;    private SearchResultAdapter searchResultAdapter;    private List<SearchResult> searchResults;    @Override    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {        binding = FragmentSearchBinding.inflate(inflater, container, false);        return binding.getRoot();    }    @Override    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {        super.onViewCreated(view, savedInstanceState);        // Setup search view        binding.svSearchTours.setIconifiedByDefault(false);        binding.svSearchTours.setIconified(false);        binding.svSearchTours.requestFocus();        binding.svSearchTours.postDelayed(new Runnable() {            @Override            public void run() {                InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);                imm.showSoftInput(binding.svSearchTours.findViewById(androidx.appcompat.R.id.search_src_text), InputMethodManager.SHOW_IMPLICIT);            }        }, 200);        // Setup cancel button        binding.btnCancel.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                NavHostFragment.findNavController(SearchFragment.this).navigate(R.id.mainFragment);            }        });        binding.rvResultItemList.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                NavHostFragment.findNavController(SearchFragment.this).navigate(R.id.audioFragment);            }        });        // Initialize RecyclerView        searchResults = getInitialSearchResults();        searchResultAdapter = new SearchResultAdapter(searchResults);        binding.rvSearchResultList.setLayoutManager(new LinearLayoutManager(getContext()));        binding.rvSearchResultList.setAdapter(searchResultAdapter);        binding.rvSearchResultList.setVisibility(View.VISIBLE); // Make sure RecyclerView is visible        // Setup search view listener        binding.svSearchTours.setOnQueryTextListener(new SearchView.OnQueryTextListener() {            @Override            public boolean onQueryTextSubmit(String query) {                // Perform the search and update the results                performSearch(query);                return false;            }            @Override            public boolean onQueryTextChange(String newText) {                // Optionally, perform search on text change                performSearch(newText);                return false;            }        });    }    private void performSearch(String query) {        // Example search logic, replace with actual search logic        List<SearchResult> filteredResults = new ArrayList<>();        for (SearchResult result : getAllSearchResults()) {            if (result.getBookTitle().toLowerCase().contains(query.toLowerCase())) {                filteredResults.add(result);            }        }        if (filteredResults.isEmpty()) {            binding.rvSearchResultList.setVisibility(View.GONE);            binding.containerNothingFound.setVisibility(View.VISIBLE);        } else {            binding.rvSearchResultList.setVisibility(View.VISIBLE);            binding.containerNothingFound.setVisibility(View.GONE);            searchResultAdapter.updateSearchResults(filteredResults);        }    }    private List<SearchResult> getInitialSearchResults() {        // Mock data, replace with actual data source        List<SearchResult> results = new ArrayList<>();        results.add(new SearchResult(R.drawable.fiksiki, "Фиксики", "London", "Дети"));        results.add(new SearchResult(R.drawable.shapkared, "Красная шапочка", "London 2", "Дети 2"));        results.add(new SearchResult(R.drawable.kolobok, "Колобок", "London 3", "Дети 3"));        return results;    }    private List<SearchResult> getAllSearchResults() {        // Mock data, replace with actual data source        List<SearchResult> results = new ArrayList<>();        results.add(new SearchResult(R.drawable.im_bk_3, "Book Title 1", "Author 1", "Description 1"));        results.add(new SearchResult(R.drawable.im_bk_4, "Book Title 2", "Author 2", "Description 2"));        results.add(new SearchResult(R.drawable.im_bk_5, "Another Title", "Another Author", "Another Description"));        return results;    }}