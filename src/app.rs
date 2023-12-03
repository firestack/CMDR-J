use leptos::{SignalGet, create_signal, component, IntoView, Scope, view, Params};
use leptos_meta::{provide_meta_context};
use leptos_router::{use_query, Params, IntoParam};

#[component]
pub fn App(cx: Scope) -> impl IntoView {
	// Provides context that manages stylesheets, titles, meta tags, etc.
	provide_meta_context(cx);

	use leptos_meta::*;
	use leptos::*;
	use leptos_router::*;

	view! {
		cx,

		// injects a stylesheet into the document <head>
		// id=leptos means cargo-leptos will hot-reload this stylesheet
		<Stylesheet id="leptos" href="/pkg/cmdr-rs.css"/>

		// sets the document title
		<Title text="Welcome to Leptos"/>

		// content for this welcome page
		<Router>
			<main>
				<Routes>
					<Route path="" view=|cx| view! { cx, <HomePage/> }/>
				</Routes>
			</main>
		</Router>
	}
}


#[derive(Params, Debug, PartialEq, Default)]
struct HomePageParams {
	count: i32,
}

/// Renders the home page of your application.
#[component]
fn HomePage(cx: Scope) -> impl IntoView {
	let query = dbg!(use_query::<HomePageParams>(cx));
	// let _ = dbg!();

	// // id: || -> usize
	// let id = move || {
	// 	query.with(|query1| {
	// 		query1
	// 			.map(|query2| query2.count)
	// 			.unwrap_or_default()
	// 	})
	// };
	// let c = dbg!(use_query_map(cx));
	// Creates a reactive value to update the button
	let (count, set_count) = create_signal(cx, 0);
	let on_click = move |_| set_count.update(|count| *count += 1);

	view! { cx,
		<h1>"Welcome to Leptos!"</h1>
		<button on:click=on_click>"Click Me: " {count}</button>
		<div class="stars stars-small"></div>
		<div class="stars stars-medium"></div>
		<div class="stars stars-big"></div>
	}
}
