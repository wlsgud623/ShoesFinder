package com.example.shoesfinder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private SearchView searchView;
    ListView searchlist;
    View window;
    FirebaseFirestore db;
    CollectionReference collectionReference;
    DocumentReference documentReference;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view =  inflater.inflate(R.layout.fragment_search, container, false);
       searchlist = (ListView) view.findViewById(R.id.searchlist);
       SearchAdapter searchAdapter = new SearchAdapter(getActivity());
       searchlist.setAdapter(searchAdapter);

       window = view.findViewById(R.id.searchwin);

       searchView = (SearchView) window.findViewById(R.id.search_window);
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String s) {
               searchAdapter.empty();
               db = FirebaseFirestore.getInstance();
                collectionReference = db.collection("shose");;
                collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                   @Override
                   public void onComplete(@NonNull Task<QuerySnapshot> task) {
                       if(task.isSuccessful()){
                           for(QueryDocumentSnapshot document : task.getResult()){
                               Log.d("check", "shoese" + document.get("name"));
                               searchAdapter.addItem(new shoes(document.get("name").toString(), document.get("brand").toString(), document.get("image").toString(), Integer.parseInt(document.get("price").toString())));
                               searchAdapter.notifyDataSetChanged();}
                       }
                       else{
                           Toast.makeText(getActivity(), "Network DB Error!",Toast.LENGTH_SHORT).show();
                       }
                   }
               });
               return false;
           }

           @Override
           public boolean onQueryTextChange(String s) {
               return false;
           }
       });
       return view;
    }
}