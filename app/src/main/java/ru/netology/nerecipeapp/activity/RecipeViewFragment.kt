package ru.netology.nerecipeapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.netology.nerecipeapp.R
import ru.netology.nerecipeapp.adapter.RecipesAdapter
import ru.netology.nerecipeapp.databinding.FragmentRecipeViewFragmentBinding
import ru.netology.nerecipeapp.viewModel.RecipeViewModel

class RecipeViewFragment : Fragment() {
    private val args by navArgs<RecipeViewFragmentArgs>()

    private val recipeViewFragmentViewModel: RecipeViewModel by viewModels(ownerProducer = ::requireParentFragment)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRecipeViewFragmentBinding.inflate(layoutInflater, container, false)
        .also { binding ->
            val viewHolder =
                RecipesAdapter.ViewHolder(binding.recipeView, recipeViewFragmentViewModel)
            recipeViewFragmentViewModel.data.observe(viewLifecycleOwner) { recipes ->
                val detailedRecipe = recipes.find { it.id == args.recipeCardId } ?: run {
                    findNavController().navigateUp()
                    return@observe
                }
                viewHolder.bind(detailedRecipe)
                binding.recipeDetail.text = detailedRecipe.recipe
                binding.recipeDetailDescription.text = detailedRecipe.description
                binding.textTime.text = detailedRecipe.time
                binding.recipeDetailName.text = detailedRecipe.name
                binding.recipeCategory.text = detailedRecipe.category.toString()
                binding.recipeDetailImage.setImageResource(R.drawable.ic_test)

            }

        }.root
}