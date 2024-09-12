import css from "./NotFound.module.css";
// import pageNotFoundImg from './404 Error with a cute animal-bro.svg'
// import pageNotFoundImg from './man on 404.svg'
// import pageNotFoundImg from './man see 404 and barrier.svg'
import pageNotFoundImg from './undraw_page_not_found_re_e9o6.svg'
function NotFound() {
	return (
		<div className={css.notFound}>
			<h1>Page Not Found</h1>
			<img loading='lazy' className={css.cat} alt="Cat hanging on 404" src={pageNotFoundImg} />
		</div>
	)
}

export default NotFound